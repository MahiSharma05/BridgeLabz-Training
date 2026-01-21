package mealplanner;

public class VegetarianMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void showMeal() {
        System.out.println("Vegetarian Meal: Dal, Rice, Vegetables");
    }
}
