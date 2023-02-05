package com.dataprocessing;

import java.io.Serializable;
import java.util.ArrayList;

public class Characters implements Serializable {
	int id;
	String characterName;
	String characterLocation;
	String characterPeriod;
	String characterDescription;
	String characterBornYear;
	String characterDiedYear;

	public static ArrayList<Characters> charactersList = new ArrayList<Characters>();

	public static ArrayList<Characters> getCharactersList() {
		return charactersList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterLocation() {
		return characterLocation;
	}

	public void setCharacterLocation(String characterLocation) {
		this.characterLocation = characterLocation;
	}

	public String getCharacterPeriod() {
		return characterPeriod;
	}

	public void setCharacterPeriod(String characterPeriod) {
		this.characterPeriod = characterPeriod;
	}

	public String getCharacterDescription() {
		return characterDescription;
	}

	public void setCharacterDescription(String characterDescription) {
		this.characterDescription = characterDescription;
	}

	public String getCharacterBornYear() {
		return characterBornYear;
	}

	public void setCharacterBornYear(String characterBornYear) {
		this.characterBornYear = characterBornYear;
	}

	public String getCharacterDiedYear() {
		return characterDiedYear;
	}

	public void setCharacterDiedYear(String characterDiedYear) {
		this.characterDiedYear = characterDiedYear;
	}

	public void addCharacter(Characters c) {
		c.setId(charactersList.size());
		charactersList.add(c);
	}
}
