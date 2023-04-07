/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { SpeciesDTO } from '../models/SpeciesDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class SpeciesControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the species to the ID
     * @param id
     * @returns SpeciesDTO Everything works fine
     * @throws ApiError
     */
    public getSpecies(
        id: string,
    ): Observable<SpeciesDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/species/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no species for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
