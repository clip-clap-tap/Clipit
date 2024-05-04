package com.clipit.clipitback.model.dto;

public class UserProfile {

	private String id;
	private String gender;
	private float height;
	private float weight;
	private int age;
	private String goal;

	public UserProfile() {
		super();
	}

	public UserProfile(String id, String gender, float height, float weight, int age, String goal) {
		super();
		this.id = id;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.goal = goal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", gender=" + gender + ", height=" + height + ", weight=" + weight + ", age="
				+ age + ", goal=" + goal + "]";
	}

}
