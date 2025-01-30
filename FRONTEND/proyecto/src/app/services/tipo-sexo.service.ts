import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import TipoSexo from '../models/TipoSexo';



@Injectable({
  providedIn: 'root'
})
export class TipoSexoService {
  private apiUrl = 'http://localhost:8080/api/tipoSexo';

  constructor(private http: HttpClient) { }

  listar(): Observable<TipoSexo[]> {
    return this.http.post<TipoSexo[]>(`${this.apiUrl}/obtener`, {});
  }

}
