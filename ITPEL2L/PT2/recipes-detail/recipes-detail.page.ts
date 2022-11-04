import { Recipe } from './../../recipe.model';
import { RecipesService } from './../recipes.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-recipes-detail',
  templateUrl: './recipes-detail.page.html',
  styleUrls: ['./recipes-detail.page.scss'],
})
export class RecipesDetailPage implements OnInit {
  loadedRecipe: Recipe;

  constructor(private activatedRoute: ActivatedRoute,
    private recipesService: RecipesService,
    private router: Router,
    private alertCtrl: AlertController
    ) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(paraMap => {
      if (!paraMap.has('recipeId')){
        //redirect
        return;
      }
      const recipeId = paraMap.get('recipeId');
      this.loadedRecipe = this.recipesService.getRecipe(recipeId);
    });
  }

  deleteRecipe(){
    this.alertCtrl
    .create({
      header: 'Confirm Delete',
      message: 'Do you want to Delete?',
      buttons: [{
        text: 'Cancel',
        role: 'cancel',
      },
      {
        text: 'Delete',
        handler: () =>{
          this.recipesService.onDeleteRecipe(this.loadedRecipe.id);
          this.router.navigate(['/recipes']);
        }
      }]
    })
    .then(alertEl => {
      alertEl.present();
    });
  }

}
