export  default class ConvertDate {
    fromOracle(date){
        if (date === null) {
            return null;
        } else {
            if (date.indexOf('.') >= 0) {
                let parts = date.split('.');
                return parts[2] + '-' + parts[1] + '-' + parts[0];
            } else {
                return date;
            }
        }
    }

fromJs(date) {
    if (date === null) {
        return null;
    } else {
        if (date.indexOf('-') >= 0) {
            let parts = date.split('-');
            return parts[2] + '.' + parts[1] + '.' + parts[0];
        } else {
            return date;
        }
    }
}
}