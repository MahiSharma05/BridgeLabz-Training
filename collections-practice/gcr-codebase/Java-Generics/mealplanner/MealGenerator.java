package mealplanner;

public class MealGenerator {

    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generating personalized meal plan...");
        meal.showMeal();
    }
}
