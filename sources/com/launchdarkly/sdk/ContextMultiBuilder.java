package com.launchdarkly.sdk;

import java.util.ArrayList;
import java.util.List;

public final class ContextMultiBuilder {
    private List<LDContext> contexts;

    ContextMultiBuilder() {
    }

    public LDContext build() {
        List<LDContext> list = this.contexts;
        if (list == null || list.size() == 0) {
            return LDContext.failed("multi-kind context must contain at least one kind");
        }
        if (this.contexts.size() == 1) {
            return this.contexts.get(0);
        }
        List<LDContext> list2 = this.contexts;
        return LDContext.createMultiInternal((LDContext[]) list2.toArray(new LDContext[list2.size()]));
    }

    public ContextMultiBuilder add(LDContext lDContext) {
        if (lDContext != null) {
            if (this.contexts == null) {
                this.contexts = new ArrayList();
            }
            if (lDContext.isMultiple()) {
                for (LDContext add : lDContext.multiContexts) {
                    this.contexts.add(add);
                }
            } else {
                this.contexts.add(lDContext);
            }
        }
        return this;
    }
}
