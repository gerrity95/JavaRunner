package com.mark.framework.animation;

import java.awt.Graphics;

public class Animation {

	private Frame[] frames;
	private double[] frameEndTimes;
	private int currentFrameIndex = 0;
	
	private double totalDuration = 0;
	private double currentTime = 0;
	
	public Animation(Frame...frames ) //This means you can specify any number of frame objects
	{
		this.frames = frames;
		frameEndTimes = new double[frames.length];
		
		for (int i = 0;i < frames.length;i++) //to mae sure frameEndTimes is the same as the amount of frames
		{
			Frame f = frames[i];
			totalDuration += f.getDuration();
			frameEndTimes[i] = totalDuration;
		}
	}
	
	public synchronized void update(float increment)
	{
		currentTime += increment;
		
		if (currentTime > totalDuration)
		{
			wrapAnimation();
		}
		
		while (currentTime > frameEndTimes[currentFrameIndex])
		{
			currentFrameIndex++;
		}
	}
	
	public synchronized void wrapAnimation()
	{
		currentFrameIndex = 0;
		currentTime %= totalDuration; //equal to cT = cT % tD
	}
	
	public synchronized void render(Graphics g, int x, int y)
	{
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, null);
	}
	
	public synchronized void render(Graphics g, int x, int y, int width, int height)
	{
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, width, height, null);
	}
	
	
}
