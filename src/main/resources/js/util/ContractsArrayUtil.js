export  default class ContractsArrayUtil {
    filteredTypeContract(filteredArray,filterArray) {
        return  filteredArray.filter(function (contract) {
            for (var i = 0; i < filterArray.length; i++) {
                if (filterArray[i]==contract.type_id)
                {
                    return true
                }
            }
        })
    }


}