package com.github.hiroyuki_sato.digdag.plugin;

import io.digdag.client.config.Config;
import io.digdag.spi.Operator;
import io.digdag.spi.OperatorContext;
import io.digdag.spi.OperatorFactory;
import io.digdag.spi.TaskResult;
import io.digdag.spi.TemplateEngine;
import io.digdag.util.BaseOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DigdagStartOperatorFactory
        implements OperatorFactory
{
    @SuppressWarnings("unused")
    private final TemplateEngine templateEngine;

    private static Logger logger = LoggerFactory.getLogger(DigdagStartOperatorFactory.class);

    public DigdagStartOperatorFactory(TemplateEngine templateEngine)
    {
        this.templateEngine = templateEngine;
    }

    public String getType()
    {
        return "digdag_start";
    }


    @Override
    public Operator newOperator(OperatorContext context)
    {
        return new DigdagStartOperator(context);
    }

    private class DigdagStartOperator
            extends BaseOperator
    {
        public DigdagStartOperator(OperatorContext context)
        {
            super(context);
        }

        @Override
        public TaskResult runTask()
        {
            Config params = request.getConfig().mergeDefault(
                    request.getConfig().getNestedOrGetEmpty("digdag_start"));

            String workflow = params.get("_command", String.class);
            String project = params.get("project", String.class);
            String session = params.get( "session", String.class);


            return TaskResult.empty(request);
        }

    }
}
