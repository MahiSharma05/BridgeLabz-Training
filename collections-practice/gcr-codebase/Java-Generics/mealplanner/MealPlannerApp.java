package mealplanner;

public class MealPlannerApp {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());

        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =  new Meal<>(new HighProteinMeal());

        System.out.println(" Meal Plans ");
        vegMeal.displayMeal();
        veganMeal.displayMeal();
        ketoMeal.displayMeal();
        proteinMeal.displayMeal();

        System.out.println("\n---Generating Meals Dynamically ---");
        MealGenerator.generateMeal(new VegetarianMeal());
        MealGenerator.generateMeal(new KetoMeal());
    }
}
