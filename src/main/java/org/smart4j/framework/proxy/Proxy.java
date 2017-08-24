package org.smart4j.framework.proxy;

/**
 * Created by sihanwang on 2017/8/24.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
