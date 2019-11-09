package colatz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class IgnoreThat {



    public static void main(String[] args) {

        new IgnoreThat();

    }



    public IgnoreThat() {

        EventQueue.invokeLater(new Runnable() {

            @Override

            public void run() {

                try {

                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

                    ex.printStackTrace();

                }



                JFrame frame = new JFrame("Testing");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.add(new TestPane());

                frame.pack();

                frame.setLocationRelativeTo(null);

                frame.setVisible(true);

            }

        });

    }



    public class TestPane extends JPanel {



        private List<List<Point>> points;



        public TestPane() {

            points = new ArrayList<>(25);

            MouseAdapter ma = new MouseAdapter() {



                private List<Point> currentPath;



                @Override

                public void mousePressed(MouseEvent e) {

                    currentPath = new ArrayList<>(25);

                    currentPath.add(e.getPoint());



                    points.add(currentPath);

                    

                }



                @Override

                public void mouseDragged(MouseEvent e) {

                    Point dragPoint = e.getPoint();

                    currentPath.add(dragPoint);

                    repaint();

                    //System.out.println(e.getPoint());

                }



                @Override

                public void mouseReleased(MouseEvent e) {

                    currentPath = null;

                }



            };



            addMouseListener(ma);

            addMouseMotionListener(ma);

        }

        

        

        

        @Override

        public Dimension getPreferredSize() {

            return new Dimension(2048, 1080);

        }
        
        public double yScale(double maxVal) {
        	return 1350/maxVal;
        }
        	
        public double xScale(double maxCount) {
        	return 2048/maxCount;
        }
        
        public int maxVal(Integer collatzNum) {
        	BigInteger a = BigInteger.valueOf(collatzNum.intValue());
    		BigInteger f = new BigInteger("2");
    		BigInteger g = new BigInteger("3");
    		BigInteger h = new BigInteger("1");
    		BigInteger i = new BigInteger("0");
    		BigInteger j = new BigInteger("2");
    		BigInteger count = new BigInteger("0");
    		
    		int maxVal = 0;
    		
    		System.out.println(a);
    		
    		while(true) {
    			if(a.intValue() > maxVal) {
    				maxVal = a.intValue();
    			}
    			if(a.mod(f).equals(i)) {
    				a = a.divide(f);
    				count = count.add(h);
    			}else {
    				a = a.multiply(g);
    				a = a.add(h);
    				a = a.divide(f);
    				count = count.add(j);
    			}
    			//System.out.println(a);
    			//System.out.println(a.mod(f).equals(i));
    			
    			if(a.equals(h)) {
    				break;
    			}
    		}
    		return maxVal;
        }
        
        public int maxCount(Integer collatzNum) {
        	BigInteger a = BigInteger.valueOf(collatzNum.intValue());
    		BigInteger f = new BigInteger("2");
    		BigInteger g = new BigInteger("3");
    		BigInteger h = new BigInteger("1");
    		BigInteger i = new BigInteger("0");
    		BigInteger j = new BigInteger("2");
    		BigInteger count = new BigInteger("0");
    		
    		System.out.println(a);
    		
    		while(true) {
    			if(a.mod(f).equals(i)) {
    				a = a.divide(f);
    				count = count.add(h);
    			}else {
    				a = a.multiply(g);
    				a = a.add(h);
    				a = a.divide(f);
    				count = count.add(j);
    			}
    			//System.out.println(a);
    			//System.out.println(a.mod(f).equals(i));
    			
    			if(a.equals(h)) {
    				break;
    			}
    		}
    		return count.intValue();
        }
        
        //public int maxCount(int collatzNum) {
        	
        //}


        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            for (List<Point> path : points) {

                Point from = null;

                for (Point p : path) {

                    if (from != null) {

                       /* g2d.drawLine(from.x, from.y, p.x, p.y);

                        g2d.drawLine(from.x + 10, from.y + 10, p.x + 10, p.y + 10);

                        g2d.drawLine(from.x + 20, from.y + 20, p.x + 20, p.y + 20);

                        g2d.drawLine(from.x + 30, from.y + 30, p.x + 30, p.y + 30);

                        g2d.drawLine(from.x + 40, from.y + 40, p.x + 40, p.y + 40);

                        g2d.drawLine(from.x + 50, from.y + 50, p.x + 50, p.y + 50);

                        g2d.drawLine(from.x + 15, from.y + 15, p.x + 15, p.y + 15);

                        g2d.drawLine(from.x + 25, from.y + 25, p.x + 25, p.y + 25);

                        g2d.drawLine(from.x + 35, from.y + 35, p.x + 35, p.y + 35);

                        g2d.drawLine(from.x + 45, from.y + 45, p.x + 45, p.y + 45);

                        g2d.drawLine(from.x + 55, from.y + 55, p.x + 55, p.y + 55);*/

                        // this is where the reflection will take place
                    	
                    	
                    	//change this one
                    	int xCollatz = 503;
                    	//bruv
                    	
                    	
                        BigInteger a = BigInteger.valueOf(xCollatz);
                		BigInteger f = new BigInteger("2");
                		BigInteger r = new BigInteger("3");
                		BigInteger h = new BigInteger("1");
                		BigInteger i = new BigInteger("0");
                		BigInteger j = new BigInteger("2");
                		BigInteger count = new BigInteger("0");
                		
                		BigInteger oldCount = new BigInteger("0");
                		BigInteger oldCollatz = new BigInteger("0");
                		
                		int maxCount = maxCount(xCollatz);
                		int maxCollatz = maxVal(xCollatz);
                		
                		System.out.println(a);
                		
                		while(true) {
                			oldCount = count;
                			oldCollatz = a;
                			if(a.mod(f).equals(i)) {
                				a = a.divide(f);
                				count = count.add(h);
                			}else {
                				a = a.multiply(r);
                				a = a.add(h);
                				a = a.divide(f);
                				count = count.add(j);
                			}
                			System.out.println(a);
                			System.out.println(count);
                			//System.out.println(a.mod(f).equals(i));
                			
                			if(a.equals(h)) {
                				break;
                			}
                			
                			g2d.setColor(Color.RED);
                			
                			//g2d.fillOval((int)((count.intValue() * xScale(maxCount)) + 20), 1367 - (int)((a.intValue() * yScale(maxCollatz))), 12, 12);
                			
                			
                			
                			g2d.drawLine((int)(oldCount.intValue() * xScale(maxCount) + 20), 1367 - (int)(oldCollatz.intValue() * yScale(maxCollatz)), (int)(count.intValue() * xScale(maxCount) + 20), 1367 - (int)(a.intValue() * yScale(maxCollatz)));
                			
                			g2d.drawString("(" + count.intValue() + "," + a.intValue() + ")", (int)(count.intValue() * xScale(maxCount) + 20), 1367 - (int)(a.intValue() * yScale(maxCollatz)));
                		}

                    }

                    from = p;

                }

            }

            g2d.dispose();

        }



    }



}
