import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor() { }

  getCategories() {
      return [
      { name: 'Categoria A' },
      { name: 'Categoria B' },
      { name: 'Categoria C' },
      { name: 'Categoria D' },
      { name: 'Categoria E' },
      { name: 'Categoria F' },
      { name: 'Categoria G' },
      { name: 'Categoria H' },
      { name: 'Categoria I' }
    ];
  }
}
