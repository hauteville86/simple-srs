package pl.karolcyprowski.simple.srs.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleMasterImpl implements ModuleMaster {
	
	private List<SimpleSrsModule> modules;

	public ModuleMasterImpl() {
		
	}
	
	public List<SimpleSrsModule> getModules() {
		if (modules == null){
			createModules();
		}
		return modules;
	}
	
	private void createModules(){
		modules = new ArrayList<SimpleSrsModule>();
	}
}
