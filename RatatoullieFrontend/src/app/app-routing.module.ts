import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListCategoryComponent } from 'src/app/list-category/list-category.component';
import { AppComponent } from 'src/app/app.component';

const routes: Routes = [
  { path: 'listCategories', component: ListCategoryComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }