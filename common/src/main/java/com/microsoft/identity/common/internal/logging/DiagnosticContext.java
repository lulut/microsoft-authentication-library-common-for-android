package com.microsoft.identity.common.internal.logging;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;

public class DiagnosticContext {

    private static final String THREAD_ID = "thread_id";

    private static final ThreadLocal<IRequestContext> sREQUEST_CONTEXT_THREAD_LOCAL =
            new ThreadLocal<IRequestContext>() {
                @Override // This is the default value for the RequestContext if it's unset
                protected RequestContext initialValue() {
                    final RequestContext defaultRequestContext = new RequestContext();
                    defaultRequestContext.put(AuthenticationConstants.AAD.CORRELATION_ID, "UNSET");
                    return defaultRequestContext;
                }
            };

    public static void setRequestContext(final IRequestContext requestContext) {
        if (null == requestContext) {
            clear();
            return;
        }

        requestContext.put(THREAD_ID, String.valueOf(Thread.currentThread().getId()));
        sREQUEST_CONTEXT_THREAD_LOCAL.set(requestContext);
    }

    public static IRequestContext getRequestContext() {
        if (!hasThreadId()) {
            setThreadId();
        }

        return sREQUEST_CONTEXT_THREAD_LOCAL.get();
    }

    private static void setThreadId() {
        sREQUEST_CONTEXT_THREAD_LOCAL.get().put(
                THREAD_ID,
                String.valueOf(Thread.currentThread().getId())
        );
    }

    private static boolean hasThreadId() {
        return sREQUEST_CONTEXT_THREAD_LOCAL.get().containsKey(THREAD_ID);
    }

    public static void clear() {
        sREQUEST_CONTEXT_THREAD_LOCAL.remove();
    }
}