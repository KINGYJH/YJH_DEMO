package com.yjh.demo.core.freemarker.directive;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by YJH on 2016/3/3.
 */
public class OverrideDirective implements TemplateDirectiveModel {

    public final static String DIRECTIVE_NAME = "override";

    public void execute(Environment env,
                        Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String name = DirectiveUtils.getRequiredParam(params, "name");
        String overrideVariableName = DirectiveUtils.getOverrideVariableName(name);

        TemplateDirectiveBodyOverrideWrapper override = DirectiveUtils.getOverrideBody(env, name);
        TemplateDirectiveBodyOverrideWrapper current = new TemplateDirectiveBodyOverrideWrapper(body, env);
        if (override == null) {
            env.setVariable(overrideVariableName, current);
        } else {
            DirectiveUtils.setTopBodyForParentBody(env, current, override);
        }
    }

    static class TemplateDirectiveBodyOverrideWrapper implements TemplateDirectiveBody, TemplateModel {
        private TemplateDirectiveBody body;
        public TemplateDirectiveBodyOverrideWrapper parentBody;
        public Environment env;

        public TemplateDirectiveBodyOverrideWrapper(TemplateDirectiveBody body,
                                                    Environment env) {
            super();
            this.body = body;
            this.env = env;
        }

        public void render(Writer out) throws TemplateException, IOException {
            if (body == null) return;
            TemplateDirectiveBodyOverrideWrapper preOverride = (TemplateDirectiveBodyOverrideWrapper) env.getVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE);
            try {
                env.setVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE, this);
                body.render(out);
            } finally {
                env.setVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE, preOverride);
            }
        }
    }

}

