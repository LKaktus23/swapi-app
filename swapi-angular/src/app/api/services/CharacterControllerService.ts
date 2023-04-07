/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import type { Observable } from 'rxjs';

import type { CharacterDTO } from '../models/CharacterDTO';

import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

@Injectable()
export class CharacterControllerService {

    constructor(public readonly http: HttpClient) {}

    /**
     * Returns the character to the ID
     * @param id
     * @returns CharacterDTO Everything works fine
     * @throws ApiError
     */
    public getCharacter(
        id: string,
    ): Observable<CharacterDTO> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/characters/get',
            query: {
                'id': id,
            },
            errors: {
                400: `Invalid id supplied`,
                404: `there is no character for given id`,
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

    /**
     * Get all available characters
     * @returns string Everything works fine
     * @throws ApiError
     */
    public getAllCharacters(): Observable<string> {
        return __request(OpenAPI, this.http, {
            method: 'GET',
            url: '/api/characters/getAll',
            errors: {
                500: `Unknown internal error occured`,
                503: `swapi is not available`,
            },
        });
    }

}
