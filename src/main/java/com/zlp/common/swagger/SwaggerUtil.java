package com.zlp.common.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.RequestHandler;
import java.util.List;

/**
 * Swagger工具类
 *
 */
@Slf4j
public class SwaggerUtil {
	
	/**
	 * 获取包集合
	 *
	 * @param apiBasePackages 多个包名集合
	 */
	public static Predicate<RequestHandler> basePackages(final List<String> apiBasePackages) {
		return input -> declaringClass(input).transform(handlerPackage(apiBasePackages)).or(true);
	}

	private static Function<Class<?>, Boolean> handlerPackage(final List<String> apiBasePackages) {
		return input -> {
			// 循环判断匹配
			for (String strPackage : apiBasePackages) {
				boolean isMatch = input.getPackage().getName().startsWith(strPackage);
				if (isMatch) {
					return true;
				}
			}
			return false;
		};
	}

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}

}
