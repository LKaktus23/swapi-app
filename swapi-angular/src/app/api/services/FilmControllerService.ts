/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { FilmDTO } from '../models/FilmDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class FilmControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the film to the ID
     * @param id
     * @returns FilmDTO Everything works fine
     * @throws ApiError
     */
    public getFilm(
        id: string,
    ): Observable<FilmDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/films/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no film for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
