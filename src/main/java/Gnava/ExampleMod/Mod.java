package Gnava.ExampleMod;

import Gnava.ExampleMod.Events.ExampleGameEvent;
import Gnava.ModApi.IMod;
import Gnava.ModApi.IModContext;

public class Mod implements IMod {
    @Override
    public void initialise(IModContext context) {
        context.gameEventRegistrar().register(new ExampleGameEvent());
    }
}
