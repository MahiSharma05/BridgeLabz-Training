package mealplanner;

public class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMeal() {
        System.out.println("Meal Type: " + mealPlan.getMealType());
        mealPlan.showMeal();
    }

    public T getMealPlan() {
        return mealPlan;
    }
}
