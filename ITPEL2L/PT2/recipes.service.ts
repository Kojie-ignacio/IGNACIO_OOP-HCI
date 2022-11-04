/* eslint-disable arrow-body-style */
import { Injectable } from '@angular/core';
import { Recipe } from '../recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {
 private recipes: Recipe[] = [
    {
      id: 'r1',
      title:'Spaghetti',
      imageUrl:'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Spaghetti_biz-Zalza_tal-Fenek.jpg/1200px-Spaghetti_biz-Zalza_tal-Fenek.jpg?20220217184748',
      ingredients:['Spaghetti','Meat','Tomato Sauce','Cheese']
    },
    {
      id: 'r2',
      title:'Chicken Burger',
      imageUrl:'https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/9732Foods_Bulacan_06.jpg/640px-9732Foods_Bulacan_06.jpg',
      ingredients:['Buns','Chicken Meat','mayonnaise','coleslaw']
    },
    {
      id: 'r3',
      title:'nachos',
      imageUrl:'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Nachos_supreme.jpg/640px-Nachos_supreme.jpg',
      ingredients:['tortilla chips','cheese','ground beef','salsa']
    },
    {
      id: 'r4',
      title:'fried rice',
      imageUrl:'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cantonese_Rice_%40_Porte_du_Bonheur_%40_Montparnasse_%40_Paris_%2833894665242%29.jpg/640px-Cantonese_Rice_%40_Porte_du_Bonheur_%40_Montparnasse_%40_Paris_%2833894665242%29.jpg',
      ingredients:['rice','egg','carrots','scallon','green peas','margarine','salt']
    },
    {
      id: 'r5',
      title:'pancake',
      imageUrl:'https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Pancakes_with_fruit.jpg/640px-Pancakes_with_fruit.jpg',
      ingredients:['pancake','whipped cream','maple syrup','blue beries','strawberries']
    }

];

  constructor() { }

  getAllRecipes(){
    return[...this.recipes];
  }

  getRecipe(recipeId: string){
    return{...this.recipes.find(recipe =>recipe.id === recipeId)};
    }

    onDeleteRecipe(recipeId: string){
      this.recipes = this.recipes.filter(recipe => {
        return recipe.id !== recipeId;
      });
    }
  }

