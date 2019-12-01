package com.example.testingforbuildday;

import java.util.ArrayList;

public class FoodItems {
    ArrayList<FoodItem> foodItems = new ArrayList<>();
    ArrayList<ArrayList<FoodItem>> foodCategories = new ArrayList<>();

    FoodItems() {
        initFoodCategories();
        initFoodItems();
    }

    public void initFoodItems() {
        for (ArrayList<FoodItem> subCategory: foodCategories) {
            foodItems.addAll(subCategory);
        }
    }

    public void initFoodCategories() {
        // filled categories
        ArrayList<FoodItem> CampusPartners = initCampusPartner();
        ArrayList<FoodItem> Cafe = initCafe();
        ArrayList<FoodItem> ResidenceDining = initResidenceDining();
        ArrayList<FoodItem> Restaurant = initRestaurant();

        foodCategories.add(CampusPartners);
        foodCategories.add(Cafe);
        foodCategories.add(ResidenceDining);
        foodCategories.add(Restaurant);
    }

    public ArrayList<FoodItem> initResidenceDining() {
        ArrayList<FoodItem> tempArrayList = new ArrayList<>();

        FoodItem openKitchen = new FoodItem("Open Kitchen",
                "From international comfort foods to custom stir fries," +
                        " vegan & vegetarian entrées and more, Open Kitchen represents" +
                        " the best of Vancouver’s diverse culinary scene. Keep an eye " +
                        "out for housemade butter chicken, awesome grilled cheese sandwiches," +
                        " specialty poutine and our beloved vegetarian southwest bowl.", "Residence");
        FoodItem feast = new FoodItem("Feast",
                "Delicious and wholesome foods from around the world. Dig into " +
                        "made-to-order burritos, West Coast salmon burgers, stone hearth Italian" +
                        " pizzas, vegan & vegetarian food and more.", "Residence");
        FoodItem gather = new FoodItem("Gather",
                "Globally inspired, locally sourced meals are our passion! Gather" +
                        " serves up fresh, healthy, West Coast contemporary cuisine with global" +
                        " inspiration seven days a week. Where else can you find gourmet burgers," +
                        " Indian food, Latin American street food, sushi burritos, and a salad bar" +
                        " serving UBC Farm produce all in one place?", "Residence");

        tempArrayList.add(openKitchen);
        tempArrayList.add(feast);
        tempArrayList.add(gather);

        return tempArrayList;
    }

    public ArrayList<FoodItem> initRestaurant() {
        ArrayList<FoodItem> tempArrayList = new ArrayList<>();

        FoodItem thePoint = new FoodItem("The Point",
                "The Point is your escape from the daily slog, conveniently located in the" +
                        " Marine Drive Residence close to Wreck Beach. We serve comfort food classics made" +
                        " from fresh, seasonal ingredients – often grown nearby at the UBC Farm.\n" +
                        "\n" +
                        "Order a local beer, play a board game with friends, and work your way through menu" +
                        " favourites like chicken and waffles, cauliflower wings, burgers, entrée salads and" +
                        " drool-worthy housemade desserts.", "Restaurant");

        FoodItem sage = new FoodItem("Sage",
                "Modern, West Coast lunch cuisine. Enjoy attentive service and panoramic views of the" +
                        " mountains and Georgia Straight. Sage also caters special events and weddings.", "Restaurant");

        tempArrayList.add(thePoint);
        tempArrayList.add(sage);

        return tempArrayList;
    }

    public ArrayList<FoodItem> initCampusPartner() {
        ArrayList<FoodItem> tempArrayList = new ArrayList<>();

        FoodItem phTea = new FoodItem("Ph Tea",
                "Get your PhD in Bubble Tea! Located on the main level of the AMS Student Nest.",
                "Campus Partner");

        FoodItem grandNoodleEmporium = new FoodItem("Grand Noodle Emporium",
                "Authentic Pan-Asian cuisine attached to a 60-seat restaurant. Grand Noodle serves up traditional " +
                        "Chinese take-out and Southeast Asian dishes with a twist including favourites like Pad Thai, Wonton " +
                        "Soup and Pho. It’s the place to go whether you’re grabbing take-out or looking to have a nice sit-down " +
                        "meal with your friends and family.",
                "Campus Partner");

        tempArrayList.add(phTea);
        tempArrayList.add(grandNoodleEmporium);

        return tempArrayList;
    }

    public ArrayList<FoodItem> initCafe() {
        ArrayList<FoodItem> tempArrayList = new ArrayList<>();

        FoodItem perugia = new FoodItem("Perugia",
                "Craving Italian for lunch? Our meals are prepared with passion in-house.\n" +
                        "\n" +
                        "Specialities include succulent roast chicken or sundried tomato salmon with salad and pasta, classic" +
                        " baked and tossed pastas, flatbreads, soups, salads and our unique Italian-style wraps and sandwiches.\n" +
                        "\n" +
                        "We also offer pastries, a delicious breakfast sandwich, and take-out gourmet salads and sandwiches." +
                        " We proudly serve organic, locally-roasted Milano coffee and Fair Trade Tea.", "Cafe");

        FoodItem ikesCafe = new FoodItem("Ike's Cafe",
                "For lunch and dinner, we offer hearty meals like mac and cheese, plant-based entrees and daily pasta." +
                        " An excellent variety of sandwiches, soups, snack items and beverages are also available.\n" +
                        "\n" +
                        "Get takeout or take a seat in our spacious indoor/outdoor dining area with views of the clock tower and library.",
                "Cafe");

        FoodItem greatDane = new FoodItem("Great Dane Coffee",
                "Great coffee. Nice people. We were sick of coffee bars that produced a great product but weren’t " +
                        "accessible or friendly. No reason to be snobby; we all have our passions. We’re super friendly, really" +
                        " good at coffee, and getting pretty good at pastries as well!",
                "Cafe");

        FoodItem blueChipCafe = new FoodItem("Blue Chip Cafe",
                "UBC’s famous Blue Chip Cookies plus made-to-order deli-style sandwiches, Bernoulli’s bagels, fresh " +
                        "pastries, and hand-crafted organic fair trade coffees and teas, as well as specialty barista drinks" +
                        " and fruit smoothies.",
                "Cafe");

        FoodItem lawCafe = new FoodItem("Law Cafe",
                "Order in the food court! Law students and others gather here daily to study and enjoy our selection of " +
                        "sandwiches, snacks and beverages.\n" +
                        "\n" +
                        "Our soups are made fresh daily using seasonal ingredients, often from UBC Farm. Hot and healthy!",
                "Cafe");

        tempArrayList.add(perugia);
        tempArrayList.add(ikesCafe);
        tempArrayList.add(greatDane);
        tempArrayList.add(blueChipCafe);
        tempArrayList.add(lawCafe);

        return tempArrayList;
    }


}