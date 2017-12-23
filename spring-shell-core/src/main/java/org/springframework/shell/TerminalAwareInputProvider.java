package org.springframework.shell;

import org.jline.terminal.Terminal;

public interface TerminalAwareInputProvider extends InputProvider{

	public Terminal getTerminal();
	
}
