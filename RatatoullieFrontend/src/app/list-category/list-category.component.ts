import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.scss']
})
export class ListCategoryComponent implements OnInit {

  categoties = [
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

  constructor() { }

  ngOnInit() {
  }

}
