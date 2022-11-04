import { Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { RecipesDetailPageRoutingModule } from './recipes-detail-routing.module';

import { RecipesDetailPage } from './recipes-detail.page';

const routes: Routes = [
  {
    path: ' ',
    component:RecipesDetailPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RecipesDetailPageRoutingModule
  ],
  declarations: [RecipesDetailPage]
})
export class RecipesDetailPageModule {}
