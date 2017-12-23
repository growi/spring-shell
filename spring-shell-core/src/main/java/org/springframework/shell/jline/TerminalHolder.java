package org.springframework.shell.jline;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

import org.jline.terminal.Attributes;
import org.jline.terminal.Cursor;
import org.jline.terminal.MouseEvent;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp.Capability;
import org.springframework.beans.factory.BeanCreationException;
import org.jline.utils.NonBlockingReader;

public class TerminalHolder implements Terminal {

	Terminal terminal;

	public TerminalHolder() {
		try {
			terminal = TerminalBuilder.builder().build();
		} catch (IOException e) {
			throw new BeanCreationException("Could not create Terminal: " + e.getMessage());
		}
	}

	@Override
	public void close() throws IOException {
		terminal.close();
	}

	@Override
	public String getName() {
		return terminal.getName();
	}

	@Override
	public SignalHandler handle(Signal signal, SignalHandler handler) {
		return terminal.handle(signal, handler);
	}

	@Override
	public void raise(Signal signal) {
		terminal.raise(signal);
	}

	@Override
	public NonBlockingReader reader() {
		return terminal.reader();
	}

	@Override
	public PrintWriter writer() {
		return terminal.writer();
	}

	@Override
	public InputStream input() {
		return terminal.input();
	}

	@Override
	public OutputStream output() {
		return terminal.output();
	}

	@Override
	public Attributes enterRawMode() {
		return terminal.enterRawMode();
	}

	@Override
	public boolean echo() {
		return terminal.echo();
	}

	@Override
	public boolean echo(boolean echo) {
		return terminal.echo(echo);
	}

	@Override
	public Attributes getAttributes() {
		return terminal.getAttributes();
	}

	@Override
	public void setAttributes(Attributes attr) {
		terminal.setAttributes(attr);
	}

	@Override
	public Size getSize() {
		return terminal.getSize();
	}

	@Override
	public void setSize(Size size) {
		terminal.setSize(size);
	}

	@Override
	public void flush() {
		terminal.flush();
	}

	@Override
	public String getType() {
		return terminal.getType();
	}

	@Override
	public boolean puts(Capability capability, Object... params) {
		return terminal.puts(capability, params);
	}

	@Override
	public boolean getBooleanCapability(Capability capability) {
		return terminal.getBooleanCapability(capability);
	}

	@Override
	public Integer getNumericCapability(Capability capability) {
		return terminal.getNumericCapability(capability);
	}

	@Override
	public String getStringCapability(Capability capability) {
		return terminal.getStringCapability(capability);
	}

	@Override
	public Cursor getCursorPosition(IntConsumer discarded) {
		return terminal.getCursorPosition(discarded);
	}

	@Override
	public boolean hasMouseSupport() {
		return terminal.hasMouseSupport();
	}

	@Override
	public boolean trackMouse(MouseTracking tracking) {
		return terminal.trackMouse(tracking);
	}

	@Override
	public MouseEvent readMouseEvent() {
		return terminal.readMouseEvent();
	}

	@Override
	public MouseEvent readMouseEvent(IntSupplier reader) {
		return terminal.readMouseEvent(reader);
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public Terminal getTerminal() {
		return this.terminal;
	}
}
