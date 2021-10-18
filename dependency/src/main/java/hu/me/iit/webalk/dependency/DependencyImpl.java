package hu.me.iit.webalk.dependency;

import org.springframework.stereotype.Component;

@Component
public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {}

    @Override
    public int helpNoParameterReturnValue() {
        return 45;
    }

    @Override
    public void helpWithParameterNoReturnValue(int a) {

    }

	@Override
	public String important(String text) {
		
		text = text.substring(0, Math.min(text.length(), 3));
		text.format(text, "...");
		
		return text;
	}
    
}
