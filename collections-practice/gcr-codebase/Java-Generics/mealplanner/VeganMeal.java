package mealplanner;

public class VeganMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void showMeal() {
        System.out.println("Vegan Meal: Salad, Fruits, Nuts");
    }
}
