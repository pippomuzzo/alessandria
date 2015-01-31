import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class PannelloVistaPdf extends JPanel implements MouseListener, KeyListener {

	private NavigatorePdf nav;
	private VistaPdf vista;
	private JScrollPane scroll;
	
	private static final long serialVersionUID = 1L;
	
	public PannelloVistaPdf(NavigatorePdf nav){
		this.nav = nav;
		
		this.setLayout(new GridLayout(1,1));
		this.vista = new VistaPdf(this.nav);
		this.vista.setFocusable(true);
		this.vista.addMouseListener(this);
		this.vista.addKeyListener(this);
		
		this.scroll = new JScrollPane(this.vista);
		this.setFocusable(true);
		this.add(scroll);
		
		this.setFocusable(true);
		this.addMouseListener(this);
		this.addKeyListener(this);
	}
	
	public VistaPdf getVista(){
		return this.vista;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.vista.requestFocusInWindow();		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int value = this.scroll.getHorizontalScrollBar().getValue();
		int extend = this.scroll.getHorizontalScrollBar().getVisibleAmount();
		int max = this.scroll.getHorizontalScrollBar().getMaximum() - extend;
		int min = this.scroll.getHorizontalScrollBar().getMinimum();
		
		if(key == KeyEvent.VK_LEFT && value <= min){
			this.nav.previousPage();
			this.scroll.getVerticalScrollBar().setValue(0);
			this.scroll.getHorizontalScrollBar().setValue(0);
		}
		else if(key == KeyEvent.VK_RIGHT && value >= max){
			this.nav.nextPage();
			this.scroll.getVerticalScrollBar().setValue(0);
			this.scroll.getHorizontalScrollBar().setValue(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
		
}
