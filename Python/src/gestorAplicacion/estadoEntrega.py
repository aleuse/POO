from enum import Enum 

class estadoEntrega(Enum):
    PROCESADA = "PROCESADA"
    EN_CAMINO = "EN_CAMINO"
    REALIZADA = "REALIZADA"
    
    def __init__(self, estadoEntrega):
        self._estadoEntrega = estadoEntrega
        
    # Getters y Setters
    def getEstadoEntrega(self):
        return self._estadoEntrega
    
    def setEstadoEntrega(self, estadoEntrega):
        self._estadoEntrega = estadoEntrega    