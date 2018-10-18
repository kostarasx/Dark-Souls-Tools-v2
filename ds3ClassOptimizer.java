package application;

//One array with info for all sc and an array with the new levelv

/*                                   		Stats[]
 * 0.Knight             					0.Level
 * 1.Mercenary								1.Vigor
 * 2.Warrior								2.Attunement
 * 3.Herald									3.Endurance 	
 * 4.Thief									4.Vitality
 * 5.Assassin								5.Strength			
 * 6.Sorcerer								6.Dexterity						
 * 7.Pyromancer								7.Intelligence			
 * 8.Cleric									8.Faith						
 * 9.Deprived								9.Luck									
*/
public class ds3ClassOptimizer {

	public static final int NUMBER_OF_CLASSES = 10;// 10 classes
	public static final int NUMBER_OF_STATS = 10;// 10 Stats
	private startingClass[] allClasses; // Array of obj startingClass for all the 10 sc
	private int[] newLevel; // Array with 10 spot for the new level of the class
	private int[] classPointer; // Points the number of class from allClasses

	private int[] userChoice;// stats entered by user

	// Constructor
	public ds3ClassOptimizer() {
		allClasses = new startingClass[NUMBER_OF_STATS];// Create of the array of obj
		newLevel = new int[NUMBER_OF_CLASSES];
		classPointer = new int[NUMBER_OF_CLASSES];
		userChoice = new int[NUMBER_OF_STATS];
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			allClasses[i] = new startingClass();
			newLevel[i] = 0; // All elements of the newLevel = 0
			classPointer[i] = 0;
		}
		for (int i = 0; i < NUMBER_OF_STATS; i++) {
			userChoice[i] = 0;
		}
	}

	// Get AllClasses
	public startingClass[] getAllClasses() {
		return allClasses;
	}

	// Set AllClasses
	public void setAllClasses(startingClass[] allClasses) {
		this.allClasses = allClasses;
	}

	// Get specific class from AllClasses
	public startingClass getspecificAllClasses(int i) {
		return allClasses[i];
	}

	// Set specific class from AllClasses
	public void setspecificAllClasses(int i, startingClass sc) {
		this.allClasses[i] = sc;
	}

	// Get newLevel
	public int[] getNewLevel() {
		return newLevel;
	}

	// Set newLevel
	public void setNewLevel(int[] newLevel) {
		this.newLevel = newLevel.clone();
	}

	// Get Class Pointer
	public int[] getClassPointer() {
		return classPointer;
	}

	// Set Class Pointer
	public void setClassPointer(int[] classPointer) {
		this.classPointer = classPointer.clone();
	}

	// Get specific class pointer
	public int getSpecificClassPointer(int i) {
		return classPointer[i];
	}
 
	// Set specific class pointer
	public void setSpecificClassPointer(int i, int classPointer) {
		this.classPointer[i] = classPointer;
	}


    // Get user Choice
	public int[] getUserChoice() {
		return userChoice;
	}

	// Set user Choice
	public void setUserChoice(int[] userChoice) {
		this.userChoice = userChoice.clone();
	}

	// Get specific user choce
	public int getSpecificUserChoice(int i) {
		return userChoice[i];
	}

	// Set specific stat
	public void setSpecificUserChoice(int i, int stat) {
		userChoice[i] = stat;
	}

	// Basic stats for all sc
	public void setBasicStats() {
		int i = 0;// counter

		// Knight
		allClasses[i].setName("Knight");
		allClasses[i].setSpecificStat(0, 9);  // Lvl = 9
		allClasses[i].setSpecificStat(1, 12); // Vgr = 12
		allClasses[i].setSpecificStat(2, 10); // Att = 10
		allClasses[i].setSpecificStat(3, 11); // End = 11
		allClasses[i].setSpecificStat(4, 15); // Vit = 15
		allClasses[i].setSpecificStat(5, 13); // Stg = 13
		allClasses[i].setSpecificStat(6, 12); // Dex = 12
		allClasses[i].setSpecificStat(7, 9);  // Int = 9
		allClasses[i].setSpecificStat(8, 9);  // Fth = 9
		allClasses[i].setSpecificStat(9, 7);  // Lck = 7
		i++; // i = 1

		// Mercenary
		allClasses[i].setName("Mercenary");
		allClasses[i].setSpecificStat(0, 8);  // Lvl = 8
		allClasses[i].setSpecificStat(1, 11); // Vgr = 11
		allClasses[i].setSpecificStat(2, 12); // Att = 12
		allClasses[i].setSpecificStat(3, 11); // End = 11
		allClasses[i].setSpecificStat(4, 10); // Vit = 10
		allClasses[i].setSpecificStat(5, 10); // Stg = 10
		allClasses[i].setSpecificStat(6, 16); // Dex = 16
		allClasses[i].setSpecificStat(7, 10); // Int = 10
		allClasses[i].setSpecificStat(8, 8);  // Fth = 8
		allClasses[i].setSpecificStat(9, 9);  // Lck = 9
		i++; // i= 2

		// 2.Warrior
		allClasses[i].setName("Warrior");
		allClasses[i].setSpecificStat(0, 7);  // Lvl = 7
		allClasses[i].setSpecificStat(1, 14); // Vgr = 14
		allClasses[i].setSpecificStat(2, 6);  // Att = 6
		allClasses[i].setSpecificStat(3, 12); // End = 12
		allClasses[i].setSpecificStat(4, 11); // Vit = 11
		allClasses[i].setSpecificStat(5, 16); // Stg = 16
		allClasses[i].setSpecificStat(6, 9);  // Dex = 9
		allClasses[i].setSpecificStat(7, 8);  // Int = 8
		allClasses[i].setSpecificStat(8, 9);  // Fth = 9
		allClasses[i].setSpecificStat(9, 11); // Lck = 11
		i++; // i = 3

		// 3.Herald
		allClasses[i].setName("Herald");
		allClasses[i].setSpecificStat(0, 9);  // Lvl = 9
		allClasses[i].setSpecificStat(1, 12); // Vgr = 12
		allClasses[i].setSpecificStat(2, 10); // Att = 10
		allClasses[i].setSpecificStat(3, 9);  // End = 9
		allClasses[i].setSpecificStat(4, 12); // Vit = 12
		allClasses[i].setSpecificStat(5, 12); // Stg = 12
		allClasses[i].setSpecificStat(6, 11); // Dex = 11
		allClasses[i].setSpecificStat(7, 8);  // Int = 8
		allClasses[i].setSpecificStat(8, 13); // Fth = 13
		allClasses[i].setSpecificStat(9, 11); // Lck = 11
		i++; // i = 4

		// 4.Thief
		allClasses[i].setName("Thief");
		allClasses[i].setSpecificStat(0, 5);  // Lvl = 5
		allClasses[i].setSpecificStat(1, 10); // Vgr = 10
		allClasses[i].setSpecificStat(2, 11); // Att = 11
		allClasses[i].setSpecificStat(3, 10); // End = 10
		allClasses[i].setSpecificStat(4, 9);  // Vit = 9
		allClasses[i].setSpecificStat(5, 9);  // Stg = 9
		allClasses[i].setSpecificStat(6, 13); // Dex = 13
		allClasses[i].setSpecificStat(7, 10); // Int = 10
		allClasses[i].setSpecificStat(8, 8);  // Fth = 8
		allClasses[i].setSpecificStat(9, 14); // Lck = 14
		i++; // i = 5

		// 5.assassin
		allClasses[i].setName("Assasin");
		allClasses[i].setSpecificStat(0, 10); // Lvl = 10
		allClasses[i].setSpecificStat(1, 10); // Vgr = 10
		allClasses[i].setSpecificStat(2, 14); // Att = 14
		allClasses[i].setSpecificStat(3, 11); // End = 11
		allClasses[i].setSpecificStat(4, 10); // Vit = 10
		allClasses[i].setSpecificStat(5, 10); // Stg = 10
		allClasses[i].setSpecificStat(6, 14); // Dex = 14
		allClasses[i].setSpecificStat(7, 11); // Int = 11
		allClasses[i].setSpecificStat(8, 9);  // Fth = 9
		allClasses[i].setSpecificStat(9, 10); // Lck = 10
		i++; // i = 6

		// 6.Sorcerer
		allClasses[i].setName("Sorcerer");
		allClasses[i].setSpecificStat(0, 6);  // Lvl = 6
		allClasses[i].setSpecificStat(1, 9);  // Vgr = 9
		allClasses[i].setSpecificStat(2, 16); // Att = 16
		allClasses[i].setSpecificStat(3, 9);  // End = 9
		allClasses[i].setSpecificStat(4, 7);  // Vit = 7
		allClasses[i].setSpecificStat(5, 7);  // Stg = 7
		allClasses[i].setSpecificStat(6, 12); // Dex = 12
		allClasses[i].setSpecificStat(7, 16); // Int = 16
		allClasses[i].setSpecificStat(8, 9);  // Fth = 7
		allClasses[i].setSpecificStat(9, 7);  // Lck = 12
		i++; // i = 7

		// 7.Pyromancer
		allClasses[i].setName("Pyromancer");
		allClasses[i].setSpecificStat(0, 8);  // Lvl = 8
		allClasses[i].setSpecificStat(1, 11); // Vgr = 11
		allClasses[i].setSpecificStat(2, 12); // Att = 12
		allClasses[i].setSpecificStat(3, 10); // End = 10
		allClasses[i].setSpecificStat(4, 8);  // Vit = 8
		allClasses[i].setSpecificStat(5, 12); // Stg = 12
		allClasses[i].setSpecificStat(6, 9);  // Dex = 9
		allClasses[i].setSpecificStat(7, 14); // Int = 14
		allClasses[i].setSpecificStat(8, 14); // Fth = 14
		allClasses[i].setSpecificStat(9, 7);  // Lck = 7
		i++; // i = 8

		// 8.Cleric
		allClasses[i].setName("Cleric");
		allClasses[i].setSpecificStat(0, 7); // Lvl = 7
		allClasses[i].setSpecificStat(1, 10); // Vgr = 10
		allClasses[i].setSpecificStat(2, 14); // Att = 14
		allClasses[i].setSpecificStat(3, 9); // End = 9
		allClasses[i].setSpecificStat(4, 7); // Vit = 7
		allClasses[i].setSpecificStat(5, 12); // Stg = 12
		allClasses[i].setSpecificStat(6, 8); // Dex = 8
		allClasses[i].setSpecificStat(7, 7); // Int = 7
		allClasses[i].setSpecificStat(8, 16); // Fth = 16
		allClasses[i].setSpecificStat(9, 13); // Lck = 13
		i++; // i = 9

		// 9.Deprived
		allClasses[i].setName("Deprived");
		allClasses[i].setSpecificStat(0, 1);  // Lvl = 1
		allClasses[i].setSpecificStat(1, 10); // Vgr = 10
		allClasses[i].setSpecificStat(2, 10); // Att = 10
		allClasses[i].setSpecificStat(3, 10); // End = 10
		allClasses[i].setSpecificStat(4, 10); // Vit = 10
		allClasses[i].setSpecificStat(5, 10); // Stg = 10
		allClasses[i].setSpecificStat(6, 10); // Dex = 10
		allClasses[i].setSpecificStat(7, 10); // Int = 10
		allClasses[i].setSpecificStat(8, 10); // Fth = 10
		allClasses[i].setSpecificStat(9, 10); // Lck = 10
		
	}

	// Store the base Stats
	public void storeTheBaseStats() {
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			allClasses[i].setBaseStats(allClasses[i].getStats());
		}
	}

	// Calculate new level when Vigor change
	public void newVigor(int vgr) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[1] = vgr;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Vigor
			if (vgr > allClasses[i].getSpecificStat(1)) {
				// Calculate and set the new level base on new Vigor
				addLevel = vgr - allClasses[i].getSpecificStat(1);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new vigor
				allClasses[i].setSpecificStat(1, vgr);
			}
			// Decrease Vigor and 0 dont care
			else if (((vgr - allClasses[i].getSpecificBaseStats(1)) > 0) && vgr != 0) {
				// Calculate and set the new level base on new Vigor
				minusLevel = allClasses[i].getSpecificStat(1) - vgr;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Vigor
				allClasses[i].setSpecificStat(1, vgr);
			}

		}
	}

	// Calculate new level when Attunement change
	public void newAttunemen(int att) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[2] = att;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Attunement
			if (att > allClasses[i].getSpecificStat(2)) {
				// Calculate the new level base on new Attunement
				addLevel = att - allClasses[i].getSpecificStat(2);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Attunement
				allClasses[i].setSpecificStat(2, att);
			}
			// Decrease Attunement and 0 dont care
			else if (((att - allClasses[i].getSpecificBaseStats(2)) > 0) && att != 0) {
				// Calculate the new level base on new Attunement
				minusLevel = allClasses[i].getSpecificStat(2) - att;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Attunement
				allClasses[i].setSpecificStat(2, att);
			}
		}
	}

	// Calculate new level when Endurance change
	public void newEndurance(int end) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[3] = end;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Endurance
			if (end > allClasses[i].getSpecificStat(3)) {
				// Calculate the new level base on new Endurance
				addLevel = end - allClasses[i].getSpecificStat(3);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Endurance
				allClasses[i].setSpecificStat(3, end);
			}
			// Decrease Endurance and 0 dont care
			else if (((end - allClasses[i].getSpecificBaseStats(3)) > 0) && end != 0) {
				// Calculate the new level base on new Endurance
				minusLevel = allClasses[i].getSpecificStat(3) - end;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Endurance
				allClasses[i].setSpecificStat(3, end);
			}
		}
	}

	// Calculate new level when Vitality change
	public void newVitality(int vit) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[4] = vit;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Vitality
			if (vit > allClasses[i].getSpecificStat(4)) {
				// Calculate the new level base on new Vitality
				addLevel = vit - allClasses[i].getSpecificStat(4);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Vitality
				allClasses[i].setSpecificStat(4, vit);
			}
			// Decrease Vitality and 0 dont care
			else if (((vit - allClasses[i].getSpecificBaseStats(4)) > 0) && vit != 0) {
				// Calculate the new level base on new Vitality
				minusLevel = allClasses[i].getSpecificStat(4) - vit;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Vitality
				allClasses[i].setSpecificStat(4, vit);
			}
		}
	}

	// Calculate new level when Strength change
	public void newStrentgh(int stg) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[5] = stg;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Strength
			if (stg > allClasses[i].getSpecificStat(5)) {
				// Calculate the new level base on new Strength
				addLevel = stg - allClasses[i].getSpecificStat(5);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Strength
				allClasses[i].setSpecificStat(5, stg);
			}
			// Decrease Strength and 0 dont care
			else if (((stg - allClasses[i].getSpecificBaseStats(5)) > 0) && stg != 0) {
				// Calculate the new level base on new Strength
				minusLevel = allClasses[i].getSpecificStat(5) - stg;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Strength
				allClasses[i].setSpecificStat(5, stg);
			}
		}
	}

	// Calculate new level when Dexterity change
	public void newDexterity(int dex) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[6] = dex;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Dexterity
			if (dex > allClasses[i].getSpecificStat(6)) {
				// Calculate the new level base on new Dexterity
				addLevel = dex - allClasses[i].getSpecificStat(6);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Dexterity
				allClasses[i].setSpecificStat(6, dex);
			}
			// Decrease Dexterity and 0 dont care
			else if (((dex - allClasses[i].getSpecificBaseStats(6)) > 0) && dex != 0) {
				// Calculate the new level base on new Dexterity
				minusLevel = allClasses[i].getSpecificStat(6) - dex;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Dexterity
				allClasses[i].setSpecificStat(6, dex);
			}
		}
	}

	// Calculate new level when Intelligence change
	public void newIntelligence(int inte) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[7] = inte;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Intelligence
			if (inte > allClasses[i].getSpecificStat(7)) {
				// Calculate the new level base on new Intelligence
				addLevel = inte - allClasses[i].getSpecificStat(7);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Intelligence
				allClasses[i].setSpecificStat(7, inte);
			}
			// Decrease Intelligence and 0 dont care
			else if (((inte - allClasses[i].getSpecificBaseStats(7)) > 0) && inte != 0) {
				// Calculate the new level base on new Intelligence
				minusLevel = allClasses[i].getSpecificStat(7) - inte;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Intelligence
				allClasses[i].setSpecificStat(7, inte);
			}
		}
	}

	// Calculate new level when Faith change
	public void newFaith(int fth) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[8] = fth;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Faith
			if (fth > allClasses[i].getSpecificStat(8)) {
				// Calculate the new level base on new Faith
				addLevel = fth - allClasses[i].getSpecificStat(8);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Intelligence
				allClasses[i].setSpecificStat(8, fth);
			}
			// Decrease Faith and 0 dont care
			else if (((fth - allClasses[i].getSpecificBaseStats(8)) > 0) && fth != 0) {
				// Calculate the new level base on new Faith
				minusLevel = allClasses[i].getSpecificStat(8) - fth;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Faith
				allClasses[i].setSpecificStat(8, fth);
			}
		}
	}

	// Calclualte new level when Luck change
	public void newLuck(int lck) {
		int addLevel;
		int minusLevel;
		int newLevel;
		userChoice[9] = lck;// Keep users input
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			// Increase Luck
			if (lck > allClasses[i].getSpecificStat(9)) {
				// Calculate the new level base on new Luck
				addLevel = lck - allClasses[i].getSpecificStat(9);//
				newLevel = allClasses[i].getSpecificStat(0) + addLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Luck
				allClasses[i].setSpecificStat(9, lck);
			}
			// Decrease Luck and 0 dont care
			else if (((lck - allClasses[i].getSpecificBaseStats(9)) > 0) && lck != 0) {
				// Calculate the new level base on new Luck
				minusLevel = allClasses[i].getSpecificStat(9) - lck;
				newLevel = allClasses[i].getSpecificStat(0) - minusLevel;
				allClasses[i].setSpecificStat(0, newLevel);
				// Set the new Luck
				allClasses[i].setSpecificStat(9, lck);
			}
		}
	}

	// Create of the newLevel array
	public void newLevelCreate() {
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			newLevel[i] = allClasses[i].getSpecificStat(0);
			classPointer[i] = i;
		}
	}

	// Short newLever array min-man bubble short
	public void newLevelSohrt() {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			for (int j = 0; j < (NUMBER_OF_CLASSES - i - 1); j++) {
				if (newLevel[j] > newLevel[j + 1]) {
					temp1 = classPointer[j];
					classPointer[j] = classPointer[j + 1];
					classPointer[j + 1] = temp1;
					temp2 = newLevel[j];
					newLevel[j] = newLevel[j + 1];
					newLevel[j + 1] = temp2;
				}
			}
		}
	}
}