package pl.karolcyprowski.simple.srs.dictionary;

import pl.karolcyprowski.simple.srs.module.SimpleSrsModule;
import pl.karolcyprowski.simple.srs.module.SimpleSrsModuleCore;

public class DictionaryModule implements SimpleSrsModule {

	@Override
	public String getName() {
		return "Dictionary";
	}
	
	public SimpleSrsModuleCore getModuleCore() {
		return null;
	}

}
