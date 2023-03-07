package com.jfg.gamermvvm.domain.use_cases.auth


// CLASE CONTENEDOR DE LOS CASOS DE USO, LA VENTAJA ESTA A LA HORA DE INJECTAR LOS CASOS DE USOS
// ESTA CLASE LOS CONTIENE A TODOS Y NO HAY QUE ESTAR INJECTANDO TODOS LOS USECASES
data class AuthUseCase(
     val getUser: GetUser,
     val login: Login
)
