package co.uk.gsck.midi.mapper.Handlers;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaHandler {
    Globals globals;
    String script;
    public LuaHandler() {
        globals = JsePlatform.standardGlobals();
    }

    public void setLuaString(String script) {
        this.script = script;
    }
    public LuaValue runScript() {
        return globals.load(script).call();
    }
}
