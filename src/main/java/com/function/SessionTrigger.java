package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Service Bus Trigger.
 */
public class SessionTrigger {
    /**
     * This function will be invoked when a new message is received at the Service Bus Queue.
     */
    @FunctionName("SessionTrigger")
    public void run(
            @ServiceBusQueueTrigger(name = "message", queueName = "queue", connection = "ServiceBusConnectionString", isSessionsEnabled = true) String message,
            final ExecutionContext context
    ) {
        context.getLogger().info("Java Service Bus Queue trigger function executed.");
        context.getLogger().info(message);
    }
}
