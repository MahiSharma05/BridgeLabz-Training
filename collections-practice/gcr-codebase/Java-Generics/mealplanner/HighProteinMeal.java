package mealplanner;

public class HighProteinMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "High Protein";
    }

    @Override
    public void showMeal() {
        System.out.println("High Protein Meal: Chicken, Beans, Paneer");
    }
}
