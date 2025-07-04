<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>주택단지정보</th>
                        <th>단지명</th>
                        <th>단지 위치</th>
                        <th>공급계획처리상태</th>
                        <th>계획서명</th>
                        <th>공급계획담당자</th>
                        <th>모집세대수</th>
                        <th>주택사업</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="단지명">{{ val.houseName }}</td>
                            <td class="whitespace-nowrap" label="단지 위치">{{ val.houseLocation }}</td>
                            <td class="whitespace-nowrap" label="공급계획처리상태">{{ val.supplyStatus }}</td>
                            <td class="whitespace-nowrap" label="계획서명">{{ val.projectName }}</td>
                            <td class="whitespace-nowrap" label="공급계획담당자">{{ val.manager }}</td>
                            <td class="whitespace-nowrap" label="모집세대수">{{ val.recruitmentCount }}</td>
                            <td class="whitespace-nowrap" label="주택사업">
                                <HousingProjectId :editMode="editMode" v-model="val.housingProjectId"></HousingProjectId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">HouseSupply 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <HouseSupply :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">HouseSupply 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="단지명" v-model="selectedRow.houseName" :editMode="true"/>
                            <String label="단지 위치" v-model="selectedRow.houseLocation" :editMode="true"/>
                            <String label="계획서명" v-model="selectedRow.projectName" :editMode="true"/>
                            <String label="공급계획담당자" v-model="selectedRow.manager" :editMode="true"/>
                            <Number label="모집세대수" v-model="selectedRow.recruitmentCount" :editMode="true"/>
                            <HousingProjectId offline label="주택단지정보" v-model="selectedRow.housingProjectId" :editMode="true"/>
                            <SupplyStatus offline label="공급계획처리상태" v-model="selectedRow.supplyStatus" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'houseSupplyGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'houseSupplies',
    }),
    watch: {
    },
    methods:{
    }
}

</script>