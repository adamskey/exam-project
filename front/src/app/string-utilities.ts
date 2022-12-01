export function isEmpty(s:string|null|undefined):boolean{
    if(s?.trim().length == 0 ||s == null || s == undefined){
        return true;
    }
    
return false;
}