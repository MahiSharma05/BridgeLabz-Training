package mealplanner;

public class KetoMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void showMeal() {
        System.out.println("Keto Meal: Eggs, Cheese, Avocado");
    }
}
