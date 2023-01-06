package com.chrosciu.shop;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ShopApplicationExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {
    private ShopApplication shopApplication;

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        shopApplication.close();
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        shopApplication = new ShopApplication();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == ShopApplication.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return shopApplication;
    }
}
