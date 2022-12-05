import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'search'
})

export class SearchPipe implements PipeTransform {

    transform(var1: string[], searchInput: string): any[] {
        if (!searchInput) {
            return [];
        } searchInput = searchInput.toLowerCase();
        return var1.filter(
            x => x.toLowerCase().includes(searchInput)
        )
    }
}