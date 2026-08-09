package Gnava.ExampleMod.Events;

import Gnava.GameApi.GameEvents.*;
import Gnava.GameApi.GameEvents.Settlements.ISettlementEventContext;

import java.util.Collections;
import java.util.random.RandomGenerator;

public final class ExampleGameEvent implements IGameEvent<ISettlementEventContext> {
    private static final GameEventId ID = new GameEventId("example_mod", "example_game_event");
    private static final EventSpecification SPEC = EventSpecification.builder(
        ID,
        GameEventScope.SETTLEMENT,
        "events.example_mod.hello"
    ).weight(2.0f)
        .oneTime()
        .build();

    @Override
    public EventSpecification specification() {
        return SPEC;
    }

    @Override
    public boolean canTrigger(ISettlementEventContext context) {
        return context.settlement().totalPopulation() > 100;
    }

    @Override
    public GameEventResult trigger(ISettlementEventContext context, RandomGenerator random) {
        return GameEventResult.withFallback(
            Collections.emptyMap(),
            "%s has over 100 population!".formatted(context.settlement().name()),
            "This settlement grew to over 100 population"
        );
    }
}
