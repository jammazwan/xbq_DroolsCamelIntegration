package jammazwan.xbq;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Component;

@Component
public class FileMaintainer {
	private boolean hasNotes;
	private boolean hasPom;
	private boolean hasReadme;
	private boolean hasExtra;
	private boolean hasJenkins;
	private KieSession ruleSession;
	private FactHandle thisHandle;

	public FileMaintainer() {
		ruleSession = KieServices.Factory.get().getKieClasspathContainer().getKieBase().newKieSession();
		Set<String> globalControlSet = new HashSet<String>();
		ruleSession.setGlobal("controlSet", globalControlSet);
		thisHandle = ruleSession.insert(this);
	}

	void takeInput(String fileName) {
		switch (fileName) {
		case "README.md":
			hasReadme = true;
			break;
		case "NOTES.md":
			hasNotes = true;
			break;
		case "EXTRA.md":
			hasExtra = true;
			break;
		case "Jenkinsfile":
			hasJenkins = true;
			break;
		case "pom.xml":
			hasPom = true;
			break;
		default:
			break;
		}
	}

	public boolean hasNotes() {
		return hasNotes;
	}

	public boolean hasPom() {
		return hasPom;
	}

	public boolean hasReadme() {
		return hasReadme;
	}

	public boolean hasExtra() {
		return hasExtra;
	}

	public boolean hasJenkins() {
		return hasExtra;
	}

	public void updateAndFireAllRules() {
		ruleSession.update(thisHandle, this);
		ruleSession.fireAllRules();
	}

	public KieSession getRuleSession() {
		return ruleSession;
	}

}
