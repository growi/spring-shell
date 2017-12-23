package org.springframework.shell;

import org.jline.terminal.Terminal;

public interface TerminalBackedInputProvider extends InputProvider {

	public Terminal getTerminal();
}
