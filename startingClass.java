package application;
//Class for starting class sc 

public class startingClass {

	private String name;// The name of sc
	private int numberOfStats;// The number of stats based of the game
	private int[] stats;// Array of int with current stats
	private int[] baseStats;// Array with Base stats

	// Constructor
	public startingClass(int numberOfStats) {
		name = new String("");// Space
		this.numberOfStats = numberOfStats;
		stats = new int[numberOfStats];// Creation of array stats
		baseStats = new int[numberOfStats];
		for (int i = 0; i < numberOfStats; i++) {
			stats[i] = 0; // All elements of the stats = 0
			baseStats[i] = 0; // All elements of the base = 0
		}
	}

	// Default Constructor
	public startingClass() {
		name = new String("");// Space
		numberOfStats = 0;
		stats = new int[10];// Creation of array stats
		baseStats = new int[10];
		for (int i = 0; i < 10; i++) {
			stats[i] = 0; // All elements of the stats = 0
			baseStats[i] = 0;// All elements of the base = 0
		}
	}

	// Get for Name
	public String getName() {
		return name;
	}

	// Set for Name
	public void setName(String name) {
		this.name = name;
	}

	// Get for NumberofStats
	public int getNumberOfStats() {
		return numberOfStats;
	}

	// Set for NumberofStats
	public void setNumberOfStats(int numberOfStats) {
		this.numberOfStats = numberOfStats;
	}

	// Get for stats
	public int[] getStats() {
		return stats;
	}

	// Set for stats
	public void setStats(int[] stats) {
		this.stats = stats.clone();
	}

	// Get specific stat
	public int getSpecificStat(int i) {
		return stats[i];
	}

	// Set specific stat
	public void setSpecificStat(int i, int stat) {
		this.stats[i] = stat;
	}

	// Get BaseStats
	public int[] getBaseStats() {
		return baseStats;
	}

	// Set BaseStats
	public void setBaseStats(int[] baseStats) {
		this.baseStats = baseStats.clone();
	}

	// Get specific BaseStats
	public int getSpecificBaseStats(int i) {
		return baseStats[i];
	}

	// Set specific BaseStats
	public void setSpecificBaseStats(int i, int stat) {
		this.baseStats[i] = stat;
	}

}
