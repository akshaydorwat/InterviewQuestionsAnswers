package sampleCodes;

/*
 * Given some tasks (given start time and end time), find the maximum number of 
 * working hours that can be achieved without overlapping any of the tasks.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Work implements Comparable<Work>
{
	String wId;
	int startTime = 0;
	int endTime = 0;
	
	Work previousWork = null;
	int workingTime = 0;
	
	public Work(String wId, int startTime, int endTime)
	{
		this.wId = wId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.workingTime = endTime - startTime;
	}
	
	public String getwId()
	{
		return wId;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public int getEndTime()
	{
		return endTime;
	}

	public int getWorkingTime()
	{
		return workingTime;
	}
	public void setWorkingTime(int maxWorkingTime, Work previousWork)
	{
		this.workingTime = maxWorkingTime;
		this.previousWork = previousWork;
	}
	
	public Work getPreviousWork()
	{
		return previousWork;
	}

	public String toString()
	{
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(wId).append("-> ");
		strBuf.append(startTime).append("-").append(endTime);
		
		return new String(strBuf);
	}

	@Override
	public int compareTo(Work o) {
		// TODO Auto-generated method stub
		if((this.endTime == o.endTime)&&(this.startTime == o.startTime))
		{
			return 0;
		}else if((this.endTime == o.endTime)&&(this.startTime != o.startTime))
		{
			return this.startTime - o.startTime;
		}else{
			return this.endTime - o.endTime;
		}
		
	}
}

public class MaxWorkingHours
{
	public static void main(String[] args)
	{
		ArrayList<Work> tasks = new ArrayList<Work>();
		tasks.add(new Work("W1", 600, 830));
		tasks.add(new Work("W2", 900, 1100));
		tasks.add(new Work("W3", 1230, 1400));
		tasks.add(new Work("W4", 800, 900));
		tasks.add(new Work("W5", 1030, 1400));
		tasks.add(new Work("W6", 900, 1130));

		//Could have used merge sort which is more time efficient
		for (int i = 0; i < tasks.size() - 1; i++)
		{
			for (int j = 0; j < tasks.size() - i - 1; j++)
			{
				if (tasks.get(j).getEndTime() > tasks.get(j + 1).getEndTime())
				{
					Work temp = tasks.get(j);
					tasks.set(j, tasks.get(j + 1));
					tasks.set(j + 1, temp);
				}
			}
		}
		//using merger sort
		//Collections.sort(tasks);
		
		for (int i = 0; i < tasks.size(); i++)
		{
			System.out.println(tasks.get(i));
		}
		System.out.println();

		Work currentMaxTask = null;
		for (int i = 0; i < tasks.size(); i++)
		{
			int maxWorkingHours = 0;
			Work previousWork = null;
			for (int j = 0; j < i; j++)
			{
				if (tasks.get(i).getStartTime() >= tasks.get(j).getEndTime() && maxWorkingHours < tasks.get(j).getWorkingTime())
				{
					maxWorkingHours = tasks.get(j).getWorkingTime();
					previousWork = tasks.get(j);
				}
			}
			maxWorkingHours += tasks.get(i).getWorkingTime();
			tasks.get(i).setWorkingTime(maxWorkingHours, previousWork);

			if (currentMaxTask == null || currentMaxTask.getWorkingTime() < tasks.get(i).getWorkingTime())
			{
				currentMaxTask = tasks.get(i);
			}
		}

		Stack<Work> maxWorkingHoursTasks = new Stack<Work>();
		while (currentMaxTask != null)
		{
			maxWorkingHoursTasks.push(currentMaxTask);
			currentMaxTask = currentMaxTask.getPreviousWork();
		}

		int maxWorkingHours = 0;
		while (!maxWorkingHoursTasks.isEmpty())
		{
			currentMaxTask = maxWorkingHoursTasks.pop();
			System.out.println(currentMaxTask);
			if (maxWorkingHours < currentMaxTask.getWorkingTime())
			{
				maxWorkingHours = currentMaxTask.getWorkingTime();
			}
		}
		System.out.println(maxWorkingHours);
	}
}
