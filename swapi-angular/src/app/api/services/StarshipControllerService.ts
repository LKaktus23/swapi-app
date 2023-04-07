/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { StarshipDTO } from '../models/StarshipDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class StarshipControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the starship to the ID
     * @param id
     * @returns StarshipDTO Everything works fine
     * @throws ApiError
     */
    public getStarship(
        id: string,
    ): Observable<StarshipDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/starships/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no starship for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
